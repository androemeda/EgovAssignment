const express = require('express');
const app = express();
const port = 8001;

app.get('/users', (req, res) => {
  res.send('Hello World1!');
});

app.listen(port, () => {
  console.log(`User service listening at http://localhost:${port}`);
});