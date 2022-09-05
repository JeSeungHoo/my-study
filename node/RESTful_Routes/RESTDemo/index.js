const express = require('express');
const app = express();
const path = require('path');
const methodOverride = require('method-override');
const { v4: uuid } = require('uuid');

// 폼 데이터 //To parse form data in POST request body:
app.use(express.urlencoded({ extended: true }));
// json 데이터 // To parse incoming JSON in POST request body:
app.use(express.json());
// method-override query key// To 'fake' put/patch/delete requests:
app.use(methodOverride('_method'));
// Views folder and EJS setup:
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

// Our fake database:
let comments = [
    {
        id: uuid(),
        // id: 1,
        username: 'Todd',
        comment: 'lol that is so funny!'
    },
    {
        id: uuid(),
        // id: 2,
        username: 'Skyler',
        comment: 'I like to go birdwatching with my dog'
    },
    {
        id: uuid(),
        // id: 3,
        username: 'Sk8erBoi',
        comment: 'Plz delete your account, Todd'
    },
    {
        id: uuid(),
        // id: 4,
        username: 'onlysayswoof',
        comment: 'woof woof woof'
    }
]

// GET /comments - list all comments
// POST /comments - Create a new comment 
// GET /comments/:id - Get one comment (using ID)
// PATCH /comments/:id - Update one comment
// DELETE /comments/:id - Destroy one comment

// 모든 댓글 목록 출력
app.get('/comments', (req, res) => {
    res.render('comments/index', { comments });
});

// 댓글 작성 폼 출력
app.get('/comments/new', (req, res) => {
    res.render('comments/new');
});

// 댓글 작성요청
app.post('/comments', (req, res) => {
    const { username, comment } = req.body;
    comments.push({ username, comment, id: uuid() });
    res.redirect('/comments');
});

// 댓글 상세보기
app.get('/comments/:id', (req, res) => {
    const { id } = req.params;
    // 주어진 판별 함수를 만족하는 첫 번째 요소의 값을 반환합니다
    const comment = comments.find(c => c.id === id);
    res.render('comments/show', { comment });
});

// 댓글 수정 폼 출력
app.get('/comments/:id/edit', (req, res) => {
    const { id } = req.params;
    const comment = comments.find(c => c.id === id);
    res.render('comments/edit', { comment });
});

// 댓글 수정요청
app.patch('/comments/:id', (req, res) => {
    const { id } = req.params;
    const newCommentText = req.body.comment;
    const foundComment = comments.find(c => c.id === id);
    // 불변성을 위배하는 것이라 현재 추세는 아님
    foundComment.comment = newCommentText;
    res.redirect('/comments');
});

// 댓글 삭제요청
app.delete('/comments/:id', (req, res) => {
    const { id } = req.params;
    comments = comments.filter(c => c.id !== id);
    res.redirect('/comments');
});





app.get('/tacos', (req, res) => {
    res.send('get /tacos response');
});

app.post('/tacos', (req, res) => {
    const { meat, qty } = req.body;
    res.send(`OK, here are your ${qty} ${meat}`);
});

app.listen(3000, () => {
    console.log('on port 3000!');
})