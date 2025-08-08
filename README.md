# Spring Boot Microservices Lab 🚀

**Dự án:** springboot-microservices-lab  
**Repository:** https://github.com/haivoDA22TTD/springboot-microservices-lab.git

---

## 1. Tóm tắt dự án

Một bộ microservices ví dụ xây dựng bằng Spring Boot và Spring Cloud, bao gồm các thành phần chính như:  
- **Config Server** – quản lý cấu hình tập trung  
- **Eureka Discovery Server** – đăng ký và phát hiện dịch vụ  
- **API Gateway** – định tuyến, bảo mật, circuit breaker  
- **Entity Services** (Customer, Order, Product, Payment...)  
- **Giao tiếp giữa các dịch vụ** qua Feign hoặc RestTemplate  
- **Tăng độ ổn định hệ thống** bằng Circuit Breaker, Tracing, Messaging (nếu có)

---

## 2. Kiến trúc tổng quan

[Config Server] ←→ [Eureka Server] ←→ [API Gateway] ←→ [Microservice A/B/C]

## 📁 Cấu trúc thư mục dự án
  ```plaintext
     springboot-microservices-lab/
│
├── frontend/                          # Frontend (React / Angular / Vue)
│   ├── package.json                   # Thông tin dự án, dependencies
│   ├── public/                        # HTML, favicon,...
│   └── src/
│       ├── App.js / App.tsx
│       ├── index.js / main.ts
│       ├── components/                # Các UI component nhỏ
│       ├── pages/                     # Các trang: Home, Product, Order...
│       └── services/                  # Hàm gọi API từ backend
│
├── backend/                           # Tất cả microservices & hệ thống backend
│   ├── config-server/
│   │   ├── src/main/resources/
│   │   │   └── application.yml
│   │   └── pom.xml
│   │
│   ├── eureka-server/
│   │   ├── src/main/resources/
│   │   │   └── application.yml
│   │   └── pom.xml
│   │
│   ├── api-gateway/
│   │   ├── src/main/resources/
│   │   │   └── application.yml        # Cấu hình định tuyến
│   │   └── pom.xml
│   │
│   ├── customer-service/
│   │   ├── src/main/java/com/example/customer/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   └── model/
│   │   ├── src/main/resources/
│   │   │   └── application.yml
│   │   └── pom.xml
│   │
│   ├── order-service/
│   ├── product-service/
│   ├── payment-service/
│   └── ...
│
├── docker-compose.yml                 # (nếu có) quản lý toàn bộ bằng Docker
├── README.md
└── .gitignore

```
## 3. Yêu cầu môi trường
  
- Java 17+
- Maven
- Git
- Docker (tuỳ chọn)

---
## 4. Hướng dẫn cài đặt & chạy

### 4.1. Clone repository

```bash
git clone https://github.com/haivoDA22TTD/springboot-microservices-lab.git
cd springboot-microservices-lab
```
### 4.2. Khởi động từng dịch vụ
  ```bash
      cd config-server
      mvn spring-boot:run
  ```
### 4.3. Eureka Discovery Server
  ```bash
      cd eureka-server
      mvn spring-boot:run
  ```
### 4.4. API Gateway
  ```bash
      cd api-gateway
      mvn spring-boot:run
  ```
### 4.5. Các microservices khác
  ```bash
      cd customer-service
      mvn spring-boot:run
  ```
  ```bash
      cd order-service
      mvn spring-boot:run
  ```
### 4.6 Các service backend và cổng 
  | Service               | Mô tả                                | Port mặc định |
|-----------------------|--------------------------------------|---------------|
| Eureka Server         | Service Discovery / Registry         | 8761          |
| API Gateway           | Cổng vào chung (Gateway)              | 8080          |      
| Auth Service          | Xác thực người dùng                   | 8081          |
| Order Service         | Quản lý đơn hàng                     | 8082          |
| Product Service       | Quản lý sản phẩm                     | 8083          |

---
 ## 🚀 Cách chạy frontend

### 1. Cài đặt dependencies

```bash
cd frontend
npm install
```
### 2.  Chạy dev server
```bash
  npm run dev
```
Mặc định sẽ chạy tại: http://localhost:5173

