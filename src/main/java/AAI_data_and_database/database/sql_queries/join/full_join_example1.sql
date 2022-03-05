es geht um declarations (kopien), welche man nicht mehr öffnen kann auf dem UI. Dies, weil das Original veranlagt und gelöscht wurde. Es gibt beim öffnen dann folgende exception:

java.lang.IllegalStateException: Predecessor e8eab597-3110-49a3-a55b-6718f4724c8d could not be found for Declaration d03c86c1-acd6-4b4b-8c16-5140c0ca9818.


man muss dann die DB bereinige, dass heisst alle kopierte declarations löschen.



es müssen folgende DBs und tbl gecheckt werden:

	-journey DB
		beovr irgendetwas bei journey_documentation gelöscht wird, sollten zuerst die passagen + dran hängende daten gelöscht werden
			query: 
		-journey_documentation -> check machen: ist dort  evtl noch eintrag drin mit original_journey_declaration_id = die vom original_journey_declaration_id
			-> müsste aber schon gelöscht worden sein, als das Original gelöscht wurde
		-query mySQL: 
			select public.passage.passage_id, public.passage.journey_documentation_id, public.transaction.id as transaction_id, public.additional_data.id as additional_data_id, public.additional_data.visual_data_id
			FROM public.passage
			LEFT JOIN public.transaction ON public.passage.passage_id = public.transaction.passage_id
			LEFT JOIN public.additional_data ON public.passage.passage_id = public.additional_data.passage_id
			WHERE public.passage.journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2';
			
		-query PostgreSQL:
			zuerst müssen die visual data gelöscht werden, dann evtl enforcement und finding und picture_reference und scanned_document, dann additional data, dann evtl obsolte_document, dann passagen
				visual data:
					select * from public.visual_data where public.visual_data.id in(
						select public.additional_data.visual_data_id from public.additional_data where public.additional_data.passage_id in (
							select public.passage.passage_id from public.passage where public.passage.journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2'
							)
						);
						
				enforcement, finding, picture_reference und scanned_document:
					kann man mit FULL JOIN machen. nötig, weil pro additional data 3x picture reference existieren
						select * from public.enforcement
						FULL JOIN public.finding ON public.enforcement.additional_data_id = public.finding.additional_data_id
						FULL JOIN public.picture_reference ON public.enforcement.additional_data_id=public.picture_reference.additional_data_id
						FULL JOIN public.scanned_document ON public.enforcement.additional_data_id=public.scanned_document.additional_data_id

						where public.enforcement.additional_data_id in(
							select public.additional_data.id from public.additional_data where public.additional_data.passage_id in (
								select public.passage.passage_id from public.passage where public.passage.journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2'
							)
						);
						
					oder halt einzeln:
						select * from public.enforcement where public.enforcement.additional_data_id in(
						select public.additional_data.id from public.additional_data where public.additional_data.passage_id in (
							select public.passage.passage_id from public.passage where public.passage.journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2'
							)
						);

					select * from public.finding where public.finding.additional_data_id in(
						select public.additional_data.id from public.additional_data where public.additional_data.passage_id in (
							select public.passage.passage_id from public.passage where public.passage.journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2'
						)
					);

					select * from public.picture_reference where public.picture_reference.additional_data_id in(
						select public.additional_data.id from public.additional_data where public.additional_data.passage_id in (
							select public.passage.passage_id from public.passage where public.passage.journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2'
						)
					);

					select * from public.scanned_document where public.scanned_document.additional_data_id in(
						select public.additional_data.id from public.additional_data where public.additional_data.passage_id in (
							select public.passage.passage_id from public.passage where public.passage.journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2'
						)
					);
					
					
				
				additional data:
					select * from public.additional_data
						where public.additional_data.passage_id IN(
							select public.passage.passage_id FROM public.passage where public.passage.journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2'
							);
							
				transaction:
					select * from public.additional_data
						where public.additional_data.passage_id IN(
							select public.passage.passage_id FROM public.passage where public.passage.journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2'
							);
					
							
				passage:
					select * FROM public.passage where public.passage.journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2';
					
				
				journey_documentation_declarations:
					SELECT * FROM public.journey_documentation_declarations
                        WHERE journey_documentation_id='37856950-d62b-45d1-a10e-d188eb305fa2';
						
				journey_documentation:
					SELECT *
                        FROM public.journey_documentation
                        WHERE id='37856950-d62b-45d1-a10e-d188eb305fa2';
				
				
	-declaration DB
		1 way_points:
			select * from public.
			
		1 crossing_missed:
		
		
		1 crossing_point:
		
		
		2 usage_statement:
		
		
			