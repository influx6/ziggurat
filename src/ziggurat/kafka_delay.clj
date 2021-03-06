(ns ziggurat.kafka-delay
  (:require [ziggurat.metrics :as metrics]
            [ziggurat.util.time :refer :all]))

(defn calculate-and-report-kafka-delay [metric-namespace record-timestamp]
  (let [now-millis (get-current-time-in-millis)
        delay      (- now-millis
                      record-timestamp)]
    (metrics/report-time metric-namespace delay)))

