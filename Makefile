all:
	LEIN_SNAPSHOTS_IN_RELEASE=1 lein do clean, uberjar
	zip -r -j firebird-exec-raw.zip target/uberjar/*-standalone.jar config.edn query.sql

zip:
	zip -r -j firebird-exec-raw.zip target/uberjar/*-standalone.jar config.edn query.sql

