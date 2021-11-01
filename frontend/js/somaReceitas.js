function createNode(element) {
    return document.createElement(element);
  }
  function append(parent, el) {
    return parent.appendChild(el);
  }
  
  const elementoReceita = document.getElementById("receita");
  
  const caminhoReceita = "http://localhost:8080/somareceitas";
  
  fetch(caminhoReceita)
    .then((resp) => resp.json())
    .then(function (data) {
      console.log(data);
      let saldo = data;
      elementoReceita.innerHTML  = saldo.toFixed(2);
    })
    .catch(function (error) {
      console.log(error);
    });