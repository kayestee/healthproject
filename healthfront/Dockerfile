FROM node:16.1-alpine as reactbuild
ARG HEALTHCHECK_URL
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json ./
COPY package-lock.json ./
COPY ./ .
ENV REACT_APP_HEALTHCHECK_URL ${HEALTHCHECK_URL}
RUN npm install
RUN npm run build

FROM nginx
COPY --from=reactbuild /app/build /usr/share/nginx/html
COPY --from=reactbuild /app/nginx/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

