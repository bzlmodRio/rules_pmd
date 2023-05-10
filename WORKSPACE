workspace(name = "rules_pmd")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# WPI Formatter
http_archive(
    name = "rules_wpiformat",
    sha256 = "e5e6fedbb0b1ffc8a34c9b53e05f94e35165bf02704d4566541aebcd87e1f0f4",
    url = "https://github.com/bzlmodRio/rules_wpiformat/releases/download/2022.30/rules_wpiformat-2022.30.tar.gz",
)

load("@rules_wpiformat//dependencies:load_rule_dependencies.bzl", "load_wpiformat_rule_dependencies")

load_wpiformat_rule_dependencies()

# Rule Dependencies
load("//dependencies:load_rule_dependencies.bzl", "load_pmd_rule_dependencies")

load_pmd_rule_dependencies()

# Transitive Dependencies

load("//dependencies:load_dependencies.bzl", "load_pmd_dependencies")

load_pmd_dependencies()

# Pin the maven install
load("@rules_pmd_dependencies//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

# Setup styleguide
load("@rules_wpiformat//dependencies:load_dependencies.bzl", "load_wpiformat_dependencies")

load_wpiformat_dependencies()

load("@rules_wpiformat_pip//:requirements.bzl", "install_deps")

install_deps()
