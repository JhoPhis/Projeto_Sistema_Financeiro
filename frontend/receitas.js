function createNode(element) {
    return document.createElement(element);
  }
  function append(parent, el) {
    return parent.appendChild(el);
  }
  
  const ul = document.getElementById('receitas');
  
  const url = 'http://localhost:8080/somadespesas';
  
  fetch(url)
  .then((resp) => resp.json())
  .then(function(data) {
    console.log(data)
    let receitas = data;
   
      let li = createNode('li');
      let img = createNode('img');
      let span = createNode('span');
      span.innerHTML = `${receitas}`;
      append(li, img);
      append(li, span);
      append(ul, li);
  
  })
  .catch(function(error) {
    console.log(error);
  });