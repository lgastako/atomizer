(ns atomizer.plugins.undo)

(def !undostates (atom {}))

(defn make-undoable! [!app & {:keys [key]
                              :or {key :undo}}]
  (swap! !undostates #(assoc % !app (list @!app)))
  (add-watch !app key (fn [k r o n]
                        (swap! !undostates #(assoc % !app (cons % n))))))

(defn undo [!app]
  (!reset !app (second (@!undostates !app))))
