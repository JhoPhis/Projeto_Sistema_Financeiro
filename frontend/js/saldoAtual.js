var saldoEle = document.getElementById("saldo");

var caminho = "http://localhost:8080/saldo";

fetch(caminho)
  .then((resp) => resp.json())
  .then(function (data) {
    console.log(data);
    let saldo = data;
    saldoEle.innerHTML = saldo.toFixed(2);
  })
  .catch(function (error) {
    console.log(error);
  });
