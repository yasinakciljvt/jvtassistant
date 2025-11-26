# jvtassistant

jvtassistant, bireylerin günlük yaşamlarını düzenlemelerine yardımcı olmak için tasarlanmış bir kişisel üretkenlik ve planlama backend uygulamasıdır.  
Kullanıcılar; günlük görevlerini, çalışma planlarını, spor aktivitelerini, beslenme rutinlerini ve kişisel hedeflerini sistem üzerinde yönetebilir.

Bu proje; Spring Boot ekosisteminin temel konularını pekiştirmek, ardından Security, JWT, Transaction, Logging, Redis, MongoDB, WebSocket, Kafka, Docker, Config Server, API Gateway gibi ileri düzey konuları gerçek bir uygulama üzerinde adım adım uygulamak için geliştirilmiştir.

---

## 🎯 Amaç

Bu proje ile öğrenilecek konular:

- Spring Core & Web
- Controller / Service / Repository katmanları
- DTO – Entity yapıları
- JPA & Hibernate ile ORM
- Validation
- Global Error Handling
- Spring Security
- JWT Authentication
- WebSocket ile bildirim sistemi
- Redis Cache
- MongoDB – Elasticsearch – Message Queue (Kafka & RabbitMQ)
- API Gateway, Service Discovery
- Config Server
- Dockerize etme

---

## 🗂️ Proje Modülleri

1. **User Management**
   - Kullanıcı kaydı
   - Profil görüntüleme
   - İleride: login, JWT, şifre güncelleme

2. **Task Management**
   - Kullanıcının günlük/haftalık görev eklemesi
   - Görev durum güncelleme
   - Görev kategorileri (Spor, Çalışma, Diyet, Kişisel, vb.)

3. **Sports Tracker (İleri aşamalarda)**
   - Spor rutini oluşturma
   - Günlük hedef takibi

4. **Diet / Meal Planner (İleri aşamalarda)**
   - Günlük yemek planı
   - Kalori hedefi

5. **Real-Time Notifications (WebSocket ile)**
   - Görev tamamlama bildirimleri
   - Günlük hatırlatma

---

## 🛠️ Teknoloji ve Frameworkler

- **Java 17**
- **Spring Boot 3**
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Lombok
- ModelMapper
- Validation
- (Sonraki aşamalarda) Security, JWT, Redis, Kafka, Docker…

