package com.mangofactory.swagger.plugin

import com.mangofactory.swagger.core.ClassOrApiAnnotationResourceGrouping
import com.mangofactory.swagger.mixins.SpringSwaggerConfigSupport
import com.mangofactory.swagger.models.alternates.AlternateTypeProvider
import com.mangofactory.swagger.address.RelativeSwaggerAddressProvider

//import com.wordnik.swagger.model.AuthorizationType
//import com.wordnik.swagger.model.ResponseMessage
import spock.lang.Specification

//import static com.mangofactory.swagger.ScalaUtils.*
@Mixin(SpringSwaggerConfigSupport)
class SwaggerSpringMvcPluginSpec extends Specification {

  SwaggerSpringMvcPlugin plugin

  void setup() {
    plugin = new SwaggerSpringMvcPlugin(springSwaggerConfig())
  }

  def "Should have sensible defaults when built with minimal configuration"() {
    when:
      plugin.build()

    then:
      plugin.swaggerGroup == 'default'
      plugin.includePatterns == [".*?"]
//      plugin.authorizationTypes == null

      plugin.apiInfo.title == 'default Title'
      plugin.apiInfo.description == 'Api Description'
      plugin.apiInfo.termsOfService == 'Api terms of service'
      plugin.apiInfo.contact.name == 'Contact Name'
      plugin.apiInfo.license.name == 'Licence Type'
      plugin.apiInfo.license.url == 'License URL'

      plugin.excludeAnnotations == []
      plugin.resourceGroupingStrategy instanceof ClassOrApiAnnotationResourceGrouping
      plugin.swaggerAddressProvider instanceof RelativeSwaggerAddressProvider
      plugin.alternateTypeProvider instanceof AlternateTypeProvider
  }

//  def "Swagger global response messages should override the default for a particular RequestMethod"() {
//    when:
//      plugin.globalResponseMessage(GET, [new ResponseMessage(OK.value(), "blah", toOption(null))])
//            .build()
//
//    then:
//      SwaggerGlobalSettings swaggerGlobalSettings = plugin.swaggerGlobalSettings
//      swaggerGlobalSettings.getGlobalResponseMessages()[GET][0].message() == "blah"
//      swaggerGlobalSettings.getGlobalResponseMessages()[GET].size() == 1
//
//    and: "defaults are preserved"
//      swaggerGlobalSettings.getGlobalResponseMessages().keySet().containsAll(
//            [POST, PUT, DELETE, PATCH, TRACE, OPTIONS, HEAD]
//      )
//
//  }
//
//  def "Swagger ignorableParameterTypes should append to the default ignorableParameterTypes"() {
//    when:
//      plugin
//            .ignoredParameterTypes(AbstractSingletonProxyFactoryBean.class, ProxyFactoryBean.class)
//            .build()
//    then:
//      SwaggerGlobalSettings swaggerGlobalSettings = plugin.swaggerGlobalSettings
//      swaggerGlobalSettings.getIgnorableParameterTypes().contains(AbstractSingletonProxyFactoryBean.class)
//      swaggerGlobalSettings.getIgnorableParameterTypes().contains(ProxyFactoryBean.class)
//
//    and: "one of the defaults"
//      swaggerGlobalSettings.getIgnorableParameterTypes().contains(ServletRequest.class)
//  }
//
//  def "Sets alternative AlternateTypeProvider with a rule"() {
//    given:
//      def provider = new AlternateTypeProvider()
//      def rule = newRule(String, String)
//
//    when:
//      plugin.alternateTypeProvider(provider)
//            .alternateTypeRules(rule)
//            .build()
//    then:
//      plugin.swaggerGlobalSettings.alternateTypeProvider == provider
//      plugin.swaggerGlobalSettings.alternateTypeProvider.rules.contains(rule)
//  }
//
//  @Unroll
//  def "generic model substitute"() {
//    when:
//      plugin."${method}"(*args).build()
//    then:
//      plugin.swaggerGlobalSettings.alternateTypeProvider.rules.size() == expectedSize
//
//    where:
//      method                    | args                               | expectedSize
//      'genericModelSubstitutes' | [ResponseEntity.class, List.class] | 7
//      'directModelSubstitute'   | [LocalDate.class, Date.class]      | 6
//  }
//
//
//  def "should contain both default and custom exclude annotations"() {
//    when:
//      plugin.excludeAnnotations(AbstractSingletonProxyFactoryBean.class, ProxyFactoryBean.class).build()
//
//    then:
//      plugin.apiListingReferenceScanner.excludeAnnotations.containsAll([
//            AbstractSingletonProxyFactoryBean.class,
//            ProxyFactoryBean.class,
//            ApiIgnore.class
//      ])
//  }
//
//  @Unroll
//  def "Basic property checks"() {
//    when:
//      plugin."$builderMethod"(object)
//
//    then:
//      plugin."$property" == object
//
//    where:
//      builderMethod          | object                                                         | property
//      'modelProvider'        | new DefaultModelProvider(null, null, null, null)               | 'modelProvider'
//      'addressProvider'         | new AbsoluteSwaggerPathProvider()                              | 'swaggerPathProvider'
//      'authorizationTypes'   | new ArrayList<AuthorizationType>()                             | 'authorizationTypes'
//      'authorizationContext' | new AuthorizationContext.AuthorizationContextBuilder().build() | 'authorizationContext'
//      'includePatterns'      | ['one', 'two', 'three'] as String[]                            | 'includePatterns'
//      'swaggerGroup'         | 'someGroup'                                                    | 'swaggerGroup'
//      'apiInfo'              | new ApiInfo('', '', '', '', '', '')                            | 'apiInfo'
//      'apiVersion'           | '2.0'                                                          | 'apiVersion'
//  }
//
//  def "non nullable swaggerApiResourceListing properties"() {
//
//    when:
//      plugin.build()
//
//    then:
//      SwaggerApiResourceListing listing = plugin.swaggerApiResourceListing
//      null != listing.swaggerGlobalSettings
//      null != listing.swaggerPathProvider
//      null != listing.apiInfo
//      null != listing.apiListingReferenceScanner
//
//      listing.swaggerGlobalSettings == plugin.swaggerGlobalSettings
//      listing.swaggerPathProvider == plugin.swaggerPathProvider
//      listing.apiInfo == plugin.apiInfo
//      listing.apiListingReferenceScanner instanceof ApiListingReferenceScanner
//      listing.swaggerCache instanceof SwaggerCache
//      listing.swaggerGroup == plugin.swaggerGroup
//      listing.apiVersion == plugin.apiVersion
//      listing.apiListingReferenceOrdering instanceof ResourceListingLexicographicalOrdering
//      listing.apiDescriptionOrdering instanceof ApiDescriptionLexicographicalOrdering
//
//  }
//
//  def "ApiListingReferenceScanner properties"() {
//    when:
//      plugin.build()
//      ApiListingReferenceScanner apiListingReferenceScanner = plugin.apiListingReferenceScanner
//
//    then:
//      apiListingReferenceScanner.excludeAnnotations == plugin.excludeAnnotations + springSwaggerConfig()
//              .defaultExcludeAnnotations()
//      apiListingReferenceScanner.resourceGroupingStrategy == plugin.resourceGroupingStrategy
//      apiListingReferenceScanner.swaggerPathProvider == plugin.swaggerPathProvider
//      apiListingReferenceScanner.swaggerGroup == plugin.swaggerGroup
//      apiListingReferenceScanner.includePatterns == plugin.includePatterns
//  }


}
