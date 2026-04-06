document.addEventListener('DOMContentLoaded', function() {
    loadHistory();
    
    // Check authentication
    const user = localStorage.getItem('medsecure_user');
    if (!user) {
        window.location.href = 'login.html';
    }
});

function loadHistory() {
    const history = JSON.parse(localStorage.getItem('medsecure_scan_history')) || [];
    const historyList = document.getElementById('historyList');
    
    if (history.length === 0) {
        historyList.innerHTML = `
            <div class="text-center py-5">
                <i class="fas fa-history fa-4x text-muted mb-3"></i>
                <h4 class="text-muted">No scan history yet</h4>
                <p>Start scanning medicines to see your history here</p>
                <a href="index.html" class="btn btn-primary mt-3">
                    <i class="fas fa-camera me-2"></i>Go to Scanner
                </a>
            </div>
        `;
        return;
    }
    
    // Sort by date (newest first)
    history.sort((a, b) => new Date(b.timestamp) - new Date(a.timestamp));
    
    let html = '';
    history.forEach((scan, index) => {
        const date = new Date(scan.timestamp);
        const statusClass = scan.status === 'genuine' ? 'success' : 'danger';
        const statusIcon = scan.status === 'genuine' ? 'check-circle' : 'exclamation-triangle';
        
        html += `
            <div class="card mb-3 border-${statusClass} shadow-sm">
                <div class="card-body">
                    <div class="d-flex justify-content-between align-items-start">
                        <div>
                            <h5 class="card-title">
                                <i class="fas fa-${statusIcon} text-${statusClass} me-2"></i>
                                ${scan.medicineName || 'Unknown Medicine'}
                            </h5>
                            <p class="card-text">
                                <small class="text-muted">
                                    <i class="fas fa-clock me-1"></i>${date.toLocaleString()}
                                </small>
                            </p>
                        </div>
                        <span class="badge bg-${statusClass}">${scan.status.toUpperCase()}</span>
                    </div>
                    
                    <div class="mt-3">
                        <p class="mb-1"><strong>Search Method:</strong> ${scan.method}</p>
                        <p class="mb-1"><strong>Query:</strong> ${scan.query}</p>
                        <p class="mb-0"><strong>Result:</strong> ${scan.result}</p>
                    </div>
                </div>
            </div>
        `;
    });
    
    historyList.innerHTML = html;
}

function clearHistory() {
    if (confirm('Are you sure you want to clear all scan history?')) {
        localStorage.removeItem('medsecure_scan_history');
        loadHistory();
    }
}