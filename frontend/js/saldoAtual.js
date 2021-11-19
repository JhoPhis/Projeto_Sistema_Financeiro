var saldoEle = document.getElementById("saldo");

var caminho = "http://localhost:8080/somareceitas";
var caminho2 = "http://localhost:8080/somadespesas";

fetch(caminho)
  .then((resp) => resp.json())
  .then(function (data) {
    console.log(data);
    let saldo = data;
    fetch(caminho2)
      .then((resp) => resp.json())
      .then(function (data) {
        console.log(data);
        saldo -= data;

        saldoEle.innerHTML = saldo.toFixed(2);
      });
    saldoEle.innerHTML = saldo.toFixed(2);
  })
  .catch(function (error) {
    console.log(error);
  });
