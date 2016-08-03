(defproject demo "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.76"]]
  :plugins [[lein-npm "0.6.2"]
            [lein-cljsbuild "1.1.3"]
            [lein-figwheel "0.5.4-3"]]
  :npm {:dependencies [[source-map-support "0.4.0"]
                       [ws "1.1.0"]
                       [connect "3.3.5"]
                       [js-yaml "3.3.0"]
                       [swagger-tools "0.10.1"]]}
  :source-paths ["src"]
  :clean-targets ["js" "repl"]
  :target-path "target"
  :cljsbuild {:builds [{:id "standard"
                        :source-paths ["src"]
                        :compiler {:output-to "js/demo.js"
                                   :output-dir "js"
                                   :source-map true
                                   :optimizations :none
                                   :target :nodejs
                                   :main "demo.main"
                                   :pretty-print true}}
                       {:id "repl"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:output-to "repl/repl.js"
                                   :output-dir "repl"
                                   :source-map true
                                   :optimizations :none
                                   :target :nodejs
                                   :main "demo.main"
                                   :pretty-print true}}]})
