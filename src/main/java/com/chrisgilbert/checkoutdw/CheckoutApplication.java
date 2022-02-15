package com.chrisgilbert.checkoutdw;

import com.chrisgilbert.checkoutdw.health.DatabaseHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.guicey.jdbi3.JdbiBundle;

public class CheckoutApplication extends Application<CheckoutConfiguration> {

    public static void main(final String[] args) throws Exception {
        new CheckoutApplication().run(args);
    }

    @Override
    public String getName() {
        return "checkout-dw";
    }

    @Override
    public void initialize(final Bootstrap<CheckoutConfiguration> bootstrap) {
        bootstrap.addBundle(
                GuiceBundle.builder()
                        .bundles(JdbiBundle.<CheckoutConfiguration>forDatabase((conf, env) -> conf.getDataSourceFactory()))
                        .enableAutoConfig(getClass().getPackage().getName())
                        .build());
    }

    @Override
    public void run(final CheckoutConfiguration configuration,
                    final Environment environment) {

        final var dbHealthCheck = new DatabaseHealthCheck();
        environment.healthChecks().register("database", dbHealthCheck);
    }

}
