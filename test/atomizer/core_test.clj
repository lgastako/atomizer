(ns atomizer.core-test
  (:require [atomizer.plugins.autoload :refer [load-or!]]
            [atomizer.plugins.autosave :refer [autosave!]]
            [atomizer.plugins.defaultapp :refer [app-or!]]
            [atomizer.plugins.logstate :refer [logstate!]]
            [atomizer.plugins.reboot :refer [make-rebootable!]]
            [atomizer.plugins.undo :refer [make-undoable!]]))

(def make-app [] {})

(def testapp (-> (atom nil)
                 (load-or! make-app)
                 (autosave!)
                 (logstate!)
                 (make-rebootable! make-app)
                 (make-undoable!)))
