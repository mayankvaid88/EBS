run:
	mvn package -f EBS-Login/pom.xml -DskipTests=true && docker-compose build --no-cache && docker-compose up --detach
stop:
	docker-compose down