const express = require('express');
const app = express();

// app.use((req, res) => {
//     console.log('We got a new request!');
//     res.send('<h1>Hello, world!</h1>');
// });

// 라우팅
// 루트 라우트
app.get('/', (req, res) => {
    res.send('<h1>This is the home page!</h1>');
});

//cats 라우트
app.get('/cats', (req, res) => {
    console.log('cat request!');
    res.send('<h1>MEOW!!!</h1>');
});

//dogs 라우트
app.get('/dogs', (req, res) => {
    console.log('dog request!');
    res.send('<h1>wooF~~</h1>');
});

//제네릭 패턴
app.get('/r/:something', (req, res) => {
    const { something } = req.params;
    res.send(`<h1>This is ${something}</h1>`);
});

app.get('/r/:something/:next', (req, res) => {
    const { something, next } = req.params;
    res.send(`<h1>This is ${something}</h1><h1>This is ${next}</h1>`);
});

//쿼리 스트링
app.get('/search', (req, res) => {
    const { q } = req.query;
    if (!q) {
        res.send('No q!');
    } else {
        res.send(`your q is ${q}`);
    }
});

// 순서 중요 ! 마지막에 위치해야 한다.
app.get('*', (req, res) => {
    res.send('<h1>알 수 없는 요청입니다!</h1>');
});

app.listen(3000, () => {
    console.log('Listening on port 3000!');
});
