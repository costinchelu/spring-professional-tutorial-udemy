| Module.Question | Spring                                                                                                                                             |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| 01.01           | What is dependency injection? Advantages.                                                                                                          |
| 01.02           | What is a pattern/anti-pattern? Is DI a pattern?                                                                                                   |
| 01.03           | What is an interface? Advantages and why are they recommended for Spring Beans.                                                                    |
| 01.04           | What is meant by "application context"                                                                                                             |
| 01.05           | What is the concept of a container and what is its lifecycle?                                                                                      |
| 01.06           | How are you going to create a new instance of an *ApplicationContext*?                                                                             |
| 01.07           | Lifecycle of a Spring Bean in an *ApplicationContext*.                                                                                             |
| 01.08           | How to create an *ApplicationContext* in an integration test?                                                                                      |
| 01.09           | What is the preferred way to close an application context? Does Spring Boot do this for you?                                                       |
| 01.10           | Describe dependency injection using: Java configuration, annotations(*@Component, @Autowired*), component scanning, stereotypes, meta-annotations. |
|                 | What are scopes for beans and what is the default scope?                                                                                           |
| 01.11           | Are beans lazily or eagerly instantiated by default?                                                                                               |
| 01.12           | What is a property source and how can we use *@PropertySource*?                                                                                    |
| 01.13           | What is a *BeanFactoryPostProcessor*, what is it used for and when it is invoked?                                                                  |
|                 | Why would you define a static *@Bean* method?                                                                                                      |
|                 | What is a *PropertySourcesPlaceholderConfigurer* used for?                                                                                         |
| 01.14           | What is a *BeanPostProcessor*, how is it different to a *BeanFactoryPostProcessor* and what do they do?                                            |
|                 | When does the *BeanPostProcessors* are called ?                                                                                                    |
|                 | What is a destroy method?                                                                                                                          |
|                 | When/How does *@PostConstruct* and *@PreDestroy* get called?                                                                                       |
|                 | How can we define an initialization or destruction method for a Spring Bean?                                                                       |
| 01.15           | What does *ComponentScanning* do?                                                                                                                  |
| 01.16           | What is the behavior of the *@Autowired* in regard to field, constructor or method injection?&nbsp;                                                |
| 01.17           | What do you have to do, if you would like to inject something into a private field and how does this impact testing?&nbsp;                         |
| 01.18           | How does the *@Qualifier* annotation complement the use of *@Autowired*?&nbsp;                                                                     |
| 01.19           | What is a proxy object and what are the two different types of proxies Spring an create?                                                           |
|                 | Advantages, disadvantages, limitations of Spring proxies.&nbsp;                                                                                    |
| 01.20           | Advantages and limitations of Java Config.&nbsp;                                                                                                   |
| 01.21           | What does the *@Bean* annotation do?&nbsp;                                                                                                         |
| 01.22           | What is the default bean id if you only use @Bean and how can it be overridden?&nbsp;                                                              |
| 01.23           | Why are we not allowed to annotate a final class with *@Configuration* and a final method with *@Bean*?                                            |
|                 | How do *@Configuration* annotated classes support singleton beans?&nbsp;                                                                           |
| 01.24           | How to configure profiles and when are they useful?&nbsp;                                                                                          |
| 01.25           | Can you use *@Bean* together with *@Profile*?&nbsp;                                                                                                |
| 01.26           | Can you use *@Component* together with *@Profile*?&nbsp;                                                                                           |
| 01.27           | How many profiles can you have?&nbsp;                                                                                                              |
| 01.28           | How do inject scalar/literal values into Spring beans?&nbsp;                                                                                       |
| 01.29           | What is *@Value* annotation used for?&nbsp;                                                                                                        |
| 01.30           | What is Spring Expression Language (SpEL for short)?&nbsp;                                                                                         |
| 01.31           | What is the Environment abstraction in Spring?&nbsp;                                                                                               |
| 01.32           | Where can properties in the environment come from?                                                                                                 |
| 01.33           | What can you reference using SpEL?&nbsp;                                                                                                           |
| 01.34           | What is the difference between $ and # in *@Value* expressions?                                                                                    |

&nbsp;



| Module.Question | Spring AOP                                                                             |
|-----------------|----------------------------------------------------------------------------------------|
| 02.01           | What is the concept of Aspect Oriented Programming and which problems does it solve?   |
|                 | What is a cross-cutting concern?                                                       |
|                 | What problems arise if you don't resolve a cross cutting concern via AOP?              |
|                 | Name three typical cross-cutting concerns.                                             |
| 02.02           | What is a pointcut, a join point, an advice, an aspect, weaving?                       |
| 02.03           | How does Spring solve (implement) a cross cutting concern?                             |
| 02.04           | Which are the limitations of the two proxy types?                                      |
|                 | What visibility must Spring bean methods have to be proxied using Spring AOP?          |
| 02.05           | How many advice types does Spring support and what are they used for?                  |
|                 | Which two advices can you use if you would like to try and catch exceptions?           |
| 02.06           | What do you have to do to enable the detection of the *@Aspect* annotation?            |
|                 | What does *@EnableAspectJAutoProxy* do?                                                |
| 02.07           | If shown pointcut expressions, would you understand them?                              |
|                 | What would be the correct pointcut expression to match both getter and setter methods? |
| 08.08           |                                                                                        |
|                 |                                                                                        |

