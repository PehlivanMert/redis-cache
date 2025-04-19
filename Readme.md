# Redis Cache with PostgreSQL Example

Bu proje, Spring Boot ile Redis Cache ve PostgreSQL entegrasyonunu sağlayarak, kullanıcı bilgilerini veritabanına kaydederken Redis cache mekanizmasını kullanır. Veritabanı işlemleri ve cache işlemleri arasında hızlı veri erişimi sağlanır.

## Özellikler

- Kullanıcı oluşturma, güncelleme ve silme işlemleri.
- PostgreSQL ile veri depolama.
- Redis cache mekanizması ile hızlı veri erişimi sağlama.
- Soft-delete mekanizması ile silinen kullanıcılar veri tabanından çıkarılmadan cache'den temizlenir.

## Kullanılan Teknolojiler

- **Spring Boot**: Backend uygulama framework'ü
- **PostgreSQL**: Veritabanı yönetim sistemi
- **Redis**: Cache mekanizması
- **Lombok**: Java sınıflarındaki boilerplate kodları azaltmak için
- **Adminer**: Veritabanı yönetimi için web tabanlı araç

## Başlangıç

### Prerequisites

- Docker ve Docker Compose yüklü olmalıdır.
- Redis ve PostgreSQL için Docker konteynerleri kullanılmaktadır.

### Docker Setup

Proje, `docker-compose.yml` dosyasındaki servislerle başlatılır. PostgreSQL ve Redis konteynerlerini başlatmak için aşağıdaki komutu çalıştırın:

```bash
docker-compose up -d
```

### Uygulama Yapılandırması

Uygulama, `application.yml` dosyasında aşağıdaki ayarları kullanır:

- **PostgreSQL** bağlantı bilgileri:
    - URL: `jdbc:postgresql://localhost:5433/redis_cache`
    - Kullanıcı adı: `postgres`
    - Şifre: `root`

- **Redis** ayarları:
    - Host: `localhost`
    - Port: `6379`

### API Kullanımı

Projede 4 temel API endpoint'i bulunmaktadır:

1. **POST /api/v1/users**: Yeni bir kullanıcı oluşturur.
2. **PUT /api/v1/users**: Mevcut bir kullanıcının şifresini günceller.
3. **DELETE /api/v1/users**: Kullanıcıyı siler (soft delete).
4. **GET /api/v1/users**: Tüm kullanıcıları getirir.
5. **GET /api/v1/users/id?id=<user_id>**: Kullanıcıyı id'ye göre getirir.

### Adminer ile Veritabanı Yönetimi

Adminer arayüzüne şu URL üzerinden erişebilirsiniz:

```
http://localhost:8001
```

Burada PostgreSQL veritabanınıza bağlanarak kullanıcı bilgilerini ve yapılarını yönetebilirsiniz.

## Sonuç

Bu proje, Redis'in hızlı veri erişim sağlama yeteneklerini kullanarak PostgreSQL ile birlikte verimli bir kullanıcı yönetim sistemi kurar. Veri tabanında yapılan değişiklikler, Redis cache ile hizalanır ve cache'in güncel tutarlılığı sağlanır.

---