(ns hotpie-raw.core
  (:gen-class)
  (:require [clojure.edn :as edn]
            [korma.core :as sql]
            [korma.db :refer :all]))

(def data (edn/read-string (slurp "config.edn")))
(def sql-query (slurp "query.sql"))
(def db-config
  (let [config (:firebird data)]
    (firebird {:db         (:database config)
               :host       (:host config)
               :port       (:port config)
               :user       (:username config)
               :password   (:password config)
               :make-pool? false})))
(defdb fdb db-config)
(default-connection fdb)

(defn exec
  "Makes database query and returns all matching rows fitting to :query."
  []
  (sql/exec-raw fdb sql-query :results))

(defn -main []
  (try
    (println (exec))
    (spit "success.log" (str (new java.util.Date) " SQL Query war erfolgreich." "\n") :append true)
    (catch Exception e (spit "error.log" (str (new java.util.Date) " Folgender Fehler ist aufgetreten: " (.getMessage e) "\n") :append true))))

(comment
  (-main)
  :foo)
