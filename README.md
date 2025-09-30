#  Vovó Crochê

Um e-commerce desenvolvido para minha avó vender os crochês feitos à mão com carinho ❤️.
O projeto tem como objetivo oferecer uma experiência de compra simples, rápida e segura, com integração de meios de pagamento, cálculo de frete e chatbot para atendimento direto no WhatsApp.

---

## 🚀 Tecnologias Utilizadas

### **Backend**
<p align="left">
  <a href="https://www.java.com" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/></a>
  <a href="https://spring.io/" target="_blank" rel="noreferrer"><img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/></a>
  <a href="https://kafka.apache.org/" target="_blank" rel="noreferrer"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/apachekafka/apachekafka-original.svg" alt="kafka" width="40" height="40"/></a>
</p>

- **Java 8+**: Linguagem principal da aplicação.
- **Spring Boot**: Framework para criação de microsserviços robustos.
- **Spring Data (JPA)**: Para persistência de dados de forma simplificada.
- **Arquitetura MVC**: Padrão de projeto para a organização do backend.
- **Apache Kafka**: Plataforma de streaming para comunicação assíncrona entre serviços.

### **Frontend**
<p align="left">
  <a href="https://reactjs.org/" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/react/react-original-wordmark.svg" alt="react" width="40" height="40"/></a>
</p>

- **React.js**: Biblioteca para construir a interface de usuário (UI) de forma moderna e reativa.

### **Banco de Dados & Cache**
<p align="left">
  <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/></a>
  <a href="https://www.mongodb.com/" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mongodb/mongodb-original-wordmark.svg" alt="mongodb" width="40" height="40"/></a>
  <a href="https://redis.io" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/redis/redis-original-wordmark.svg" alt="redis" width="40" height="40"/></a>
</p>

- **MySQL**: Banco de dados relacional principal para dados de pedidos, clientes e produtos.
- **MongoDB**: Banco de dados NoSQL para logs e dados não estruturados.
- **Redis**: Cache em memória para otimizar a performance de consultas e gerenciamento de sessões.

### **DevOps & Cloud**
<p align="left">
  <a href="https://www.docker.com/" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/></a>
  <a href="https://aws.amazon.com" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/amazonwebservices/amazonwebservices-original-wordmark.svg" alt="aws" width="40" height="40"/></a>
  <a href="https://nginx.org" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/nginx/nginx-original.svg" alt="nginx" width="40" height="40"/></a>
  <a href="https://github.com/features/actions" target="_blank" rel="noreferrer"><img src="https://www.vectorlogo.zone/logos/github_actions/github_actions-icon.svg" alt="git actions" width="40" height="40"/></a>
</p>

- **Docker**: Conteinerização da aplicação e serviços.
- **AWS**: Infraestrutura em nuvem para deploy.
  - **VPC, Sub-redes Públicas/Privadas, Internet/NAT Gateway, Route Tables**: Estrutura de rede segura e isolada.
  - **EC2**: Máquinas virtuais para hospedar os contêineres Docker.
- **Nginx**: Proxy reverso e balanceador de carga para a aplicação.
- **GitHub Actions**: Automação de CI/CD para build, testes e deploy.

### **Testes & APIs Externas**
- **JMeter**: Testes de carga e performance para garantir a escalabilidade.
- **API ViaCEP**: Preenchimento automático de endereço.
- **API Correios**: Cálculo de frete em tempo real.
- **API Efí Bank**: Integração para pagamentos via Pix, boleto e cartão.
- **API WhatsApp**: Conexão com o chatbot para atendimento.

---

## ✨ Principais Funcionalidades

- [✔] Catálogo completo de produtos com fotos e descrições.
- [✔] Carrinho de compras persistente.
- [✔] Cálculo de frete integrado e automático.
- [✔] Checkout de pagamento seguro e transparente.
- [✔] Área do cliente para gestão e acompanhamento de pedidos.
- [✔] Painel administrativo para gestão de produtos, estoque e vendas.
- [✔] Suporte ao cliente via chatbot no WhatsApp.

---

## ⚙️ Como Executar Localmente

**1. Clone o repositório:**
```bash
git clone [https://github.com/seu-usuario/vovo-croche.git](https://github.com/seu-usuario/vovo-croche.git)
cd vovo-croche
```
### 2. Suba a infraestrutura com Docker:
*(Isso irá iniciar o MySQL, MongoDB, Redis e Kafka)*

```bash
docker-compose up -d
```

### 3. Execute o Backend (Spring Boot):
```bash
cd backend
mvn spring-boot:run
```

### 4. Execute o Frontend (React):
```bash
cd ../frontend
npm install
npm start
```

Acesse o projeto no navegador:  
👉 [http://localhost:3000](http://localhost:3000)

---

## 🤝 Contribuidores  
Um projeto feito com muito carinho por:

<img src="[https://avatars.githubusercontent.com/u/luger-mano?v=4](https://avatars.githubusercontent.com/u/172287862?v=4)" width=115>  
<sub>Lucas Germano</sub>

---

## 📊 Exportar para as Planilhas  
Sinta-se à vontade para contribuir! ✨
