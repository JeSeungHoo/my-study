const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/showApp')
    .then(() => {
        console.log('Conneciton Open!');
    })
    .catch(err => {
        console.log('OMG!!!!! ERROR!');
        console.log(err);
    });

const personSchema = new mongoose.Schema({
    first: String,
    last: String
});

// 가상의 특성 정의
personSchema.virtual('fullName')
    .get(function () { // 게터 정의
        return `${this.first} ${this.last}`;
    })
    .set(function (v) {
        // ~.fullname = value; 시 작동
        this.first = v.substr(0, v.indexOf(' '));
        this.last = v.substr(v.indexOf(' '));
    });

// 미들웨어
personSchema.pre('save', async function () {
    this.first = 'YO';
    this.last = 'MaMA';
    console.log('세이브 전 작동');
});
personSchema.post('save', async function () {
    console.log('세이브 후 작동');
});

const Person = mongoose.model('Person', personSchema);

const me = new Person({ first: '제', last: '제' });
me.save().then(p => console.log(p));
