async function post(obj) {
  try {
    var mEmail = document.getElementById("username").value;
    var mSenha = document.getElementById("password").value;

    obj = {
      username: mEmail,
      password: mSenha,
    };
    const req = await fetch("http://localhost:8080/users/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },

      body: JSON.stringify({
        username: mEmail,
        password: mSenha,
      }),
    })
    const res = await req.json();
    console.log(res);
    if(res == 'SUCCESS'){
        window.location.href="./receitas.html"
    }else{
        alert('Usuário e/ou senha incorreto(s)')
    }
  } catch (err) {
    console.error(`ERROR: ${err}`);
  }
}
