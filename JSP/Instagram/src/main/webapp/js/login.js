const idInput = document.getElementById('userID');
const pwInput = document.getElementById('userPW');
const loginBtn = document.getElementById('btn_login');
const linkToMain = document.getElementsByTagName('a')[0];

idInput.addEventListener('keyup', function(event) {
    if (idInput.value && pwInput.value) {
        loginBtn.disabled = false;
        linkToMain.href = "C:/22_2-instagram/Instagram/JSP/Instagram/src/main/webapp/loginAction.jsp";
    }
    else {
        loginBtn.disabled = true;
        linkToMain.href = "#none";
    }
})

pwInput.addEventListener('keyup', function(event) {
    if (idInput.value && pwInput.value) {
        loginBtn.disabled = false;
        linkToMain.href = "C:/22_2-instagram/Instagram/JSP/Instagram/src/main/webapp/loginAction.jsp";
    }
    else {
        loginBtn.disabled = true;
        linkToMain.href = "#none";
    }
})

document.addEventListener('keyup', function(event) {
    if (event.keyCode === 13) {
        document.getElementById("btn_login").click();
    }
})