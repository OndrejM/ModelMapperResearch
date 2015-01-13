# ModelMapperResearch
Research about ModelMapper Java library

 - See notes in Company class and proofs in jUnit tests

## Notes about ModelMapper
 - in simplest form, mapping done automatically using strategies
 - if mapping failures are silent, only correctly mapped data are transformed
   - validation of correct mapping must be requested manually at runtime (or tested in unit test): http://modelmapper.org/user-manual/validation/
 - possibly a great feature is integration to other frameworks (advantage over dozer), although for CDI a custom provider must be written
   - http://modelmapper.org/user-manual/integrations/
