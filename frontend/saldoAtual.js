function createNode(element) {
  return document.createElement(element);
}
function append(parent, el) {
  return parent.appendChild(el);
}

const ele = document.getElementById("saldo");

const caminho = "http://localhost:8080/saldo";

fetch(caminho)
  .then((resp) => resp.json())
  .then(function (data) {
    console.log(data);
    let saldo = data;
    ele.innerHTML  = saldo.toFixed(2);
  })
  .catch(function (error) {
    console.log(error);
  });
