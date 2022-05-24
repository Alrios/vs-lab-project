FROM node:16

# Create the folder /vs-lab-project/frontend/
RUN mkdir -p /vs-lab-project/frontend/

WORKDIR /vs-lab-project/frontend/

COPY ./frontend/package.json .
COPY ./frontend/package-lock.json .
COPY ./frontend/data data
COPY ./frontend/public public
COPY ./frontend/src src

RUN npm install

CMD npm start