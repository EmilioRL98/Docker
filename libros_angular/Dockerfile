FROM node:18 AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Etapa final basada en Nginx con Node.js y sonar-scanner instalados
FROM nginx:alpine
RUN apk add --no-cache nodejs npm curl
RUN npm install -g sonar-scanner

# Configuración de Nginx
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=builder /app/dist/ /usr/share/nginx/html/
