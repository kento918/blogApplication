document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    // ログイン処理をここに追加
    console.log('ユーザーネーム:', username);
    console.log('パスワード:', password);

});