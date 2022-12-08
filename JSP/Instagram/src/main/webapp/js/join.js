const idInput = document.getElementById('userID');
const pwInput = document.getElementById('userPW');
const nickInput = document.getElementById('userNickname');
const nameInput = document.getElementById('userName');
const joinBtn = document.getElementsByClassName('joinBtn');
const linkToMain = document.getElementsByTagName('a')[0];

idInput.addEventListener('keyup', function(event) {
    if (idInput.value && pwInput.value && nickInput.value && nameInput.value) {
        joinBtn.disabled = false;
        linkToMain.href = "C:/22_2-instagram/Instagram/JSP/Instagram/src/main/webapp/joinAction.jsp";
    }
    else {
        joinBtn.disabled = true;
        linkToMain.href = "#none";
    }
})

pwInput.addEventListener('keyup', function(event) {
    if (idInput.value && pwInput.value && nickInput.value && nameInput.value) {
        joinBtn.disabled = false;
        linkToMain.href = "C:/22_2-instagram/Instagram/JSP/Instagram/src/main/webapp/joinAction.jsp";
    }
    else {
        joinBtn.disabled = true;
        linkToMain.href = "#none";
    }
})

nickInput.addEventListener('keyup', function(event) {
    if (idInput.value && pwInput.value && nickInput.value && nameInput.value) {
        joinBtn.disabled = false;
        linkToMain.href = "C:/22_2-instagram/Instagram/JSP/Instagram/src/main/webapp/joinAction.jsp";
    }
    else {
        joinBtn.disabled = true;
        linkToMain.href = "#none";
    }
})

nameInput.addEventListener('keyup', function(event) {
    if (idInput.value && pwInput.value && nickInput.value && nameInput.value) {
        joinBtn.disabled = false;
        linkToMain.href = "C:/22_2-instagram/Instagram/JSP/Instagram/src/main/webapp/joinAction.jsp";
    }
    else {
        joinBtn.disabled = true;
        linkToMain.href = "#none";
    }
})

document.addEventListener('keyup', function(event) {
    if (event.keyCode === 13) {
        document.getElementByClassName("joinBtn").click();
    }
})