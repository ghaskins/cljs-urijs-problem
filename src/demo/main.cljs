(ns demo.main
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(def bad-juju (nodejs/require "uri-js"))

(defn -main [& args]
  (println "Hello World"))

(set! *main-cli-fn* -main)
