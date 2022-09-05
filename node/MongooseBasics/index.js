const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/movieApp')
    .then(() => {
        console.log('Conneciton Open!');
    })
    .catch(err => {
        console.log('OMG!!!!! ERROR!');
        console.log(err);
    });

// 스키마 생성
const movieSchema = new mongoose.Schema({
    title: String,
    year: Number,
    score: Number,
    rating: String
});

// 모델 생성 (모델명, 스키마) 
// -> 자동으로 movies라는 collection 생성됨
const Movie = mongoose.model('Movie', movieSchema);
// 모델의 인스턴스 생성 : 생성만으로는 db에 아무 영향 X
// const amadeus = new Movie({ title: 'Amadeus', year: 1986, score: 9.2, rating: 'R' });
// amadeus.save() // -> db에 저장

// Movie.insertMany([ // Promise 반환
//     { title: 'Amelie', year: 2001, score: 8.3, rating: 'R' },
//     { title: 'Alien', year: 1979, score: 8.1, rating: 'R' },
//     { title: 'The Iron Giant', year: 1999, score: 7.5, rating: 'PG' },
//     { title: 'Stand By Me', year: 1986, score: 8.6, rating: 'R' },
//     { title: 'Moonrise Kingdom', year: 2012, score: 7.3, rating: 'PG-13' }
// ])
//     .then(data => {
//         console.log("IT WORKED!")
//         console.log(data);
//     });


