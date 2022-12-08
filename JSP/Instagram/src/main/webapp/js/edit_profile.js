// const idInput = document.getElementById('userID');
const pwInput = document.getElementById('userPW');
const nickInput = document.getElementById('userNickname');
const messageInput = document.getElementById('userMessage');
const btn_edit = document.getElementByClassName('btn_edit');
const linkToMain = document.getElementsByTagName('a')[0];

/*
idInput.addEventListener('keyup', function(event) {
    if (idInput.value && pwInput.value && nickInput.value && messageInput.value) {
        btn_edit.disabled = false;
        linkToMain.href = "C:/22_2-instagram/Instagram/JSP/Instagram/src/main/webapp/joinAction.jsp";
    }
    else {
        btn_dit.disabled = true;
        linkToMain.href = "#none";
    }
})
*/

pwInput.addEventListener('keyup', function(event) {
    if (pwInput.value && nickInput.value && messageInput.value) {
        btn_edit.disabled = false;
        linkToMain.href = "C:/22_2-instagram/Instagram/JSP/Instagram/src/main/webapp/edit_profileAction.jsp";
    }
    else {
        btn_edit.disabled = true;
        linkToMain.href = "#none";
    }
})

nickInput.addEventListener('keyup', function(event) {
    if (pwInput.value && nickInput.value && messageInput.value) {
        btn_edit.disabled = false;
        linkToMain.href = "C:/22_2-instagram/Instagram/JSP/Instagram/src/main/webapp/joinAction.jsp";
    }
    else {
        btn_dit.disabled = true;
        linkToMain.href = "#none";
    }
})

messageInput.addEventListener('keyup', function(event) {
    if (pwInput.value && nickInput.value && messageInput.value) {
        btn_edit.disabled = false;
        linkToMain.href = "C:/22_2-instagram/Instagram/JSP/Instagram/src/main/webapp/joinAction.jsp";
    }
    else {
        btn_dit.disabled = true;
        linkToMain.href = "#none";
    }
})

document.addEventListener('keyup', function(event) {
    if (event.keyCode === 13) {
        document.getElementByClassName("btn_edit").click();
    }
})