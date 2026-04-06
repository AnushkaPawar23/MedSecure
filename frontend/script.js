async function loadFAQs() {
    try {
        const res = await fetch(`${API_BASE_URL}/faqs`);
        const faqs = await res.json();
        const container = document.getElementById('faqContainer');
        if (container) {
            container.innerHTML = faqs.map(faq => `
                <div class="faq-item">
                    <div class="faq-question" onclick="toggleFAQ(this)">
                        <i class="fas fa-question-circle me-2"></i> ${faq.question}
                        <i class="fas fa-chevron-down float-end"></i>
                    </div>
                    <div class="faq-answer">${faq.answer}</div>
                </div>
            `).join('');
        }
    } catch (error) {
        const container = document.getElementById('faqContainer');
        if (container) container.innerHTML = '<div class="alert alert-danger">Unable to load FAQs. Make sure backend is running.</div>';
    }
}

function toggleFAQ(element) {
    const item = element.closest('.faq-item');
    item.classList.toggle('active');
    const icon = element.querySelector('.fa-chevron-down');
    icon.style.transform = item.classList.contains('active') ? 'rotate(180deg)' : 'rotate(0deg)';
}

function animateCounter(el, start, end, duration) {
    let startTime = null;
    const step = (timestamp) => {
        if (!startTime) startTime = timestamp;
        const progress = Math.min((timestamp - startTime) / duration, 1);
        el.innerText = Math.floor(progress * (end - start) + start);
        if (progress < 1) requestAnimationFrame(step);
    };
    requestAnimationFrame(step);
}

function loadStats() {
    animateCounter(document.getElementById('verifiedCount'), 0, 500000, 2000);
    animateCounter(document.getElementById('userCount'), 0, 12500, 2000);
    animateCounter(document.getElementById('fakeDetectedCount'), 0, 1250, 2000);
}

document.addEventListener('DOMContentLoaded', () => {
    if (document.getElementById('faqContainer')) loadFAQs();
    if (document.getElementById('verifiedCount')) loadStats();
});