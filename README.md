# pib-inet

## Setup
Die Webanwendung wurde mittel Docker kontainerisiert wodurch das Starten und Bereitstellen um ein Vielfaches vereinfacht wurde. Die Anwendung sowie die benötigte Datenbank lässt sich mittels des Kommandos ```docker-compose up -d --build``` im Root-Ordner des Repositories starten. Sobald beide Container gebaut und gestartet wurden lässt sich die Webanwendung über die IP des Docker-Hosts und den Port 8080 aufrufen und verwenden.

## User-Management
Zur Verwaltung der existierenden Benutzer wurde ein admin-Account fest in den Security-Einstellungen der Anwendung hinterlegt. Die Anmeldung mit diesem Konto geschieht mit Bentuzername `admin` und Paswort `admin`.
