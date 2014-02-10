(ns atomizer.plugins.reboot)

(defn make-rebootable! [!app make-app]
  (set! (.-reboot js/document) #(reset! !app (make-app)))
  !app)
