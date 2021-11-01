function createNode(element) {
  return document.createElement(element);
}
function append(parent, el) {
  return parent.appendChild(el);
}

const elementoDespesa = document.getElementById("despesa");

const caminhoDespesa = "http://localhost:8080/somadespesas";

fetch(caminhoDespesa)
  .then((resp) => resp.json())
  .then(function (data) {
    console.log(data);
    let saldo = data;
    elementoDespesa.innerHTML  = saldo.toFixed(2);
  })
  .catch(function (error) {
    console.log(error);
  });