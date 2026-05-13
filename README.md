# 💊 MedSecure – Counterfeit Medicine Verification System

**MedSecure** is a web application that helps users verify whether a medicine is **genuine**, **fake**, or **expired**. It provides three verification methods: search by name/batch/barcode, real‑time barcode scanning, and photo upload (AI‑simulated). Registered users can save their verification history.

---

## ✨ Features

- 🔍 **Type to Verify** – search by medicine name, batch number, or barcode.
- 📷 **Real‑time Barcode Scanner** – uses device camera to scan barcodes (jsQR library).
- 📸 **Photo Upload** – simulated AI analysis (always returns genuine for demo).
- 👤 **User Authentication** – register / login with personal history storage.
- 📜 **Verification History** – every check is saved; users can clear their history.
- 📱 **Responsive Design** – works on desktop and mobile (Bootstrap 5).

---

## 🛠️ Tech Stack

| Layer       | Technologies |
|-------------|--------------|
| **Backend** | Java 17, Spring Boot, Spring Data JPA (Hibernate), MySQL |
| **Frontend**| HTML5, CSS3, Bootstrap 5, JavaScript (ES6), jsQR (barcode scanner) |
| **Database**| MySQL (Aiven / Railway / local) |
| **Tools**   | Maven, Git, GitHub, IntelliJ IDEA / VS Code |

---

