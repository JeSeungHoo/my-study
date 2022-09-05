const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/showApp')
    .then(() => {
        console.log('Conneciton Open!');
    })
    .catch(err => {
        console.log('OMG!!!!! ERROR!');
        console.log(err);
    });

const productSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
        maxLength: 20
    },
    price: {
        type: Number,
        required: true,
        min: [0, '가격은 음수가 될 수 없습니다!']
    },
    onSale: {
        type: Boolean,
        default: false
    },
    categories: {
        type: [String],
        default: ['cycling']
    },
    qty: {
        online: {
            type: Number,
            default: 0
        },
        inStore: {
            type: Number,
            default: 0
        }
    },
    size: {
        type: String,
        enum: ['S', 'M', 'L']
    }
});

// 인스턴스 메소드
productSchema.methods.greet = function () {
    console.log('Hello! World! by -', this.name);
};
productSchema.methods.toggleOnSale = function () {
    this.onSale = !this.onSale;
    return this.save();
};
productSchema.methods.addCategory = function (newCategory) {
    this.categories.push(newCategory);
    return this.save();
};

// 정적 메소드
productSchema.statics.fireSale = function () {
    // 이 때의 this는 Model (Product)
    return this.updateMany({}, { onSale: true, price: 0 });
}

const findProduct = async () => {
    const foundProduct = await Product.findOne({ name: 'Bike Helmet Mk.2' });
    console.log(foundProduct);
    await foundProduct.toggleOnSale();
    console.log(foundProduct);
    await foundProduct.addCategory('Outdoors');
    console.log(foundProduct);
};

const Product = mongoose.model('Product', productSchema);

// findProduct();

Product.fireSale().then(res => console.log(res));

// const bike = new Product({
//     name: 'Cycling Jersey',
//     price: 28.6,
//     other: 'haha', // 스키마에 정의되지 않은 특성은 무시된다!
//     categories: ['Cycling', 'Safety'],
//     size: 'XS'
// });

// bike.save()
//     .then(data => {
//         console.log(data);
//     })
//     .catch(err => {
//         console.log(err);
//     });

// // 업데이트 시에는 유효성 검사가 되지 않는다!!!
// Product.findOneAndUpdate(
//     { name: 'Tire Pump' },
//     { price: -10.99 },
//     {
//         new: true,
//         runValidators: true // 유효성 검사
//     })
//     .then(data => {
//         console.log(data);
//     })
//     .catch(err => {
//         console.log(err);
//     });