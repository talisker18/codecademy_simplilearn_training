SELECT * FROM (
                  SELECT a.apdu_identifier as ack_adu_id_provider, a.provider_message_id as provider_message_id, a.date_received,b.apdu_identifier as ezv_adu_id, b.outgoing_message_type as ezv_adu_type, a.conversation_id, b.date_published,

                         CASE
                             WHEN (extract(epoch from (a.date_received - b.date_published)) > 86400)
                                 THEN 'TRUE'
                             ELSE 'FALSE'
                         END AS tooLate

                  FROM public.message a
                           INNER JOIN public.message b ON a.in_response_to_apdu_id = b.apdu_identifier
                  WHERE a.incoming_message_type = 'ACK_ADU' AND a.provider_identifier=40
              ) as innerTable

WHERE tooLate='TRUE';