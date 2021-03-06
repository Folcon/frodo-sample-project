(defproject sample-project "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.5.1"]

                 [jarohen/nomad "0.6.2"]
                 [jarohen/chord "0.2.2"]
                 [ring/ring-core "1.2.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]

                 [org.clojure/clojurescript "0.0-2156"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [org.clojure/tools.reader "0.8.3"]
                 [om "0.3.6"]]

  :plugins [[lein-pdo "0.1.1"]
            [lein-cljsbuild "1.0.2"]
            [jarohen/lein-frodo "0.2.11"]
            [lein-heroku-deploy "0.1.0"]]

  :hooks [leiningen.cljsbuild]

  :frodo/config-resource "sample-project-config.edn"

  :source-paths ["src/clj"]

  :resource-paths ["resources" "target/resources"]

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :compiler {
                                   :output-to "target/resources/js/sample-project.js"
                                   :output-dir "target/resources/out"
                                   :optimizations :none
                                   :pretty-print true
                                   :source-map true}}

                       {:id "release"
                        :source-paths ["src/cljs"]
                        :compiler {
                                   :output-to "target/resources/js/sample-project.js"
                                   :optimizations :advanced
                                   :pretty-print false}}]}

  :aliases {"dev" ["pdo" "cljsbuild" "auto" "dev," "frodo"]
            "prod" ["pdo" "cljsbuild" "once" "release," "frodo"]}

  :min-lein-version "2.0.0")


