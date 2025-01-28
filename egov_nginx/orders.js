const express = require('express');
const app = express();
const port = 8002;

app.get('/orders', (req, res) => {
  res.send('Hello World2!');
});

app.listen(port, () => {
  console.log(`Order service listening at http://localhost:${port}`);
});