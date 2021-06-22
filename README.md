# spring-oauth2-demo
 
Das Projekt ist eine Erweiterung des vorherigen Projektes [spring-data-bike-rest-demo](https://github.com/MarioNeugebauer/spring-data-bike-rest-demo).
Es enthält eine Sicherung des Zugriffs auf die Ressourcen (/bike, etc) mittels [OAuth 2.0](https://datatracker.ietf.org/doc/html/rfc6749) Abschnitt 4.1 Authorization Code Grant. Als Authorization Server wird github eingesetzt.

## Inbetriebnahme

Es ist ein Github-Account erforderlich. Um das Projekt in Betrieb zu nehmen, muss eine clientID und ein clientSecret für diese Anwendung im eigenen Github-Account erzeugt werden. Damit wird die Identifikation über den Github-Account ermöglicht. Diese Genehmigung kann jederzeit widerrufen werden.

Um die clientId und das clientSecret zu erzeugen, müssen die Informationen im eigenen Github-Account erzeugt werden:
`Settings -> Developer Settings -> OAuth Apps -> Register a new application`

Anschließend müssen clientId und clientSecret in der Datei application.yml eingetragen werden. Ein Template für diese Datei befindet src/main/resources und muss nach der Eintragung von clientId und clientSecret noch umbenannt werden in application.yml.

## Frontend in index.html

Falls sich der User noch nicht authentifiziert hat, wird mittels der index.html eine Weiterleitung auf die Login-Seite von Github erzeugt. Dort identifiziert sich der User mit Login/PW. Nach erfolgreicher Authentifizierung muss die Verwendung der Daten durch die genannte App vom genannten Entwickler bestätigt werden. Abschließend zum Login-Vorgang wird dann auf localhost weitergeleitet.

Es erscheinen dann die Informationen, die nur bei vorliegender Authentifizierung sichtbar sind. Das umfasst den Usernamen, den Logout-Button und einen Button, mit welchem die vorkonfigurierten Daten geladen werden können.

## SpringOauth2DemoApplication

Für die Konfiguration muss die Klasse von `WebSecurityConfigurerAdapter` erben.

Es wird lediglich konfiguriert, welche Ressourcen ohne / mit Authentifizierung erreichbar sein sollen. In der Zeile
```.antMatchers("/", "/error", "/webjars/**").permitAll()```
können dafür die offen zugänglichen Endpunkte (Ressourcen) eingestellt werden. Vorkonfiguriert als erreichbar ohne Authentifizierung sind dabei das Wurzelverzeichnis der Anwendung (`/`), eine Seite für Fehlermeldungen (`/error`) und das Verzeichnis für die Programmcodes des HTML-JavaScript-Webclients (`/webjars/**`). Hierbei handelt es sich um eine Whitelist. Alle anderen Ressourcen dürfen nur mit Authentifizierung erreicht werden.
```.anyRequest().authenticated()```




