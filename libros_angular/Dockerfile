FROM node:18 AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Etapa final basada en Nginx
FROM nginx:alpine
RUN apk add --no-cache nodejs npm curl
RUN npm install -g sonar-scanner

# Configuración de Nginx: Copiar nginx.conf desde la raíz del contexto de construcción
COPY default.conf /etc/nginx/conf.d/default.conf


# Copiar los archivos del frontend compilado
COPY --from=builder /app/dist/libros/browser /usr/share/nginx/html/

