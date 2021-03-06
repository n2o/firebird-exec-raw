(defproject hotpie-raw "0.1"
  :description "Execute raw SQL query in firebird database."
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.csv "0.1.3"]
                 [org.firebirdsql.jdbc/jaybird "2.2.5"]
                 [korma "0.4.3"]]
  :main ^:skip-aot hotpie-raw.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
