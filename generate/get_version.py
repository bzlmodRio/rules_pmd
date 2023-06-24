from get_pmd_group import get_pmd_group


def main():
    group = get_pmd_group()
    print(group.version)


if __name__ == "__main__":
    main()
