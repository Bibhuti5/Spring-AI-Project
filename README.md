# 🧠 Spring Boot AI Chat API (OpenAI + Spring AI + Swagger)

This is a simple Spring Boot application that integrates with **OpenAI** using **Spring AI**, and exposes a REST API to chat with the AI model (GPT-3.5/4). It also includes **Swagger UI** for easy testing.

---

## 📦 Tech Stack

- Java 17+
- Spring Boot 3.2+
- Spring AI (`spring-ai-openai-spring-boot-starter`)
- OpenAI API
- Swagger (Springdoc OpenAPI)

---

## 🚀 Features

- Chat with OpenAI via REST API
- Uses Spring AI abstraction (`OpenAiChatClient`)
- Swagger UI documentation at `/swagger-ui.html`
- Advanced AI Endpoints:
    - Generate images from prompts
    - Describe uploaded images
    - Summarize videos (e.g., YouTube)
    - Review Java code
    - Generate interview Q&A

---

## 🔧 Prerequisites

- Java 17+
- Maven 3.6+
- OpenAI API Key (create one at [platform.openai.com](https://platform.openai.com))

---

## 🛠️ Setup Instructions

### 1. Clone the Repo

```bash
git clone https://github.com/your-username/spring-ai-openai-chat-api.git
cd spring-ai-openai-chat-api
```

### 2. Add Your OpenAI API Key

Update `src/main/resources/application.yml`:

```yaml
spring:
  ai:
    openai:
      api-key: YOUR_OPENAI_API_KEY
      chat:
        model: gpt-3.5-turbo
```

> Replace `YOUR_OPENAI_API_KEY` with your actual OpenAI key.

---

### 3. Build and Run

```bash
./mvnw spring-boot:run
```

---

## 🧪 API Usage

### 📬 POST `/chat`
**Input:**
```json
{
  "message": "Tell me a joke"
}
```
**Output:**
```json
"Why don't scientists trust atoms? Because they make up everything!"
```

---

### 🖼️ POST `/image/generate`
**Input:**
```json
{
  "prompt": "A futuristic city on Mars"
}
```
**Output:**
```json
"[Mocked] Generated image for prompt: A futuristic city on Mars"
```

---

### 📸 POST `/image/describe`
Upload an image using `multipart/form-data`.

**Output:**
```json
"[Mocked] Description of uploaded image: sample.jpg"
```

---

### 📹 POST `/video/summarize`
**Input:**
```json
{
  "url": "https://www.youtube.com/watch?v=abc123"
}
```
**Output:**
```json
"[Mocked] Summary of video at URL: https://www.youtube.com/watch?v=abc123"
```

---

### 🧑‍💻 POST `/chat/code-review`
**Input:**
```json
{
  "code": "public class MyService { ... }"
}
```
**Output:**
```json
"You should consider extracting this logic into a separate method..."
```

---

### 💬 GET `/chat/interview-qa?topic=java+multithreading`
**Output:**
```json
[
  "Question 1 with answer",
  "Question 2 with answer",
  "Question 3 with answer"
]
```

---

## 🌐 Swagger UI

Visit: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

You can try the `/chat` and other endpoints directly from the browser.

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/chat/
│   │       ├── ChatController.java
│   │       └── Application.java
│   └── resources/
│       └── application.yml
└── test/
```

---

## 🤖 Dependency Notes

Add the following to your `pom.xml`:

### 🧠 Spring AI
```xml
<dependency>
  <groupId>org.springframework.ai</groupId>
  <artifactId>spring-ai-openai-spring-boot-starter</artifactId>
  <version>0.8.0</version>
</dependency>
```

### 📚 Swagger
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.8.5</version>
</dependency>
```

### 🧰 Spring Milestone Repo
```xml
<repositories>
  <repository>
    <id>spring-milestones</id>
    <url>https://repo.spring.io/milestone</url>
  </repository>
</repositories>
```

---

## 📜 License

MIT

---

## 🙋‍♂️ Want more?

- Add support for chat history (memory)
- Use LangChain4J or prompt templates
- Deploy to Docker or Kubernetes
