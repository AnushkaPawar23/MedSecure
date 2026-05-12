const API_BASE_URL = 'https://medsecure.up.railway.app/api';

function checkAuth() {
    const user = localStorage.getItem('medsecure_user');
    if (user) {
        const userData = JSON.parse(user);
        const usernameSpan = document.getElementById('usernameDisplay');
        if (usernameSpan) usernameSpan.innerText = userData.fullName || userData.username;
        document.getElementById('authLinks')?.classList.add('d-none');
        document.getElementById('registerLink')?.classList.add('d-none');
        document.getElementById('userMenu')?.classList.remove('d-none');
    } else {
        document.getElementById('userMenu')?.classList.add('d-none');
        document.getElementById('authLinks')?.classList.remove('d-none');
        document.getElementById('registerLink')?.classList.remove('d-none');
    }
}

function logout() {
    localStorage.removeItem('medsecure_user');
    window.location.href = 'index.html';
}

document.addEventListener('DOMContentLoaded', () => {
    if (document.getElementById('usernameDisplay')) checkAuth();
});
