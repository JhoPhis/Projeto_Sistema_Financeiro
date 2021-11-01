function createNode(element) {
    return document.createElement(element);
  }
  function append(parent, el) {
    return parent.appendChild(el);
  }
  
  const ele = document.getElementById("receita");
  
  const caminho = "http://localhost:8080/somareceitas";
  
  fetch(caminho)
    .then((resp) => resp.json())
    .then(function (data) {
      console.log(data);
      let receita = data;
      ele.innerHTML  = receita.toFixed(2);
    })
    .catch(function (error) {
      console.log(error);
    });
  