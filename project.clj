(defproject atomizer "0.1.0-SNAPSHOT"
  :description "automatic management of your application atoms"
  :url "http://github.com/atomic-labs/atomizer"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/main.js"
                                   :output-dir "resources/public/js"
                                   :optimizations :whitespace
                                   :pretty-print true
                                   :source-map "resources/public/js/main.js.map"}}]}
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [com.cemerick/piggieback "0.1.2"]])
